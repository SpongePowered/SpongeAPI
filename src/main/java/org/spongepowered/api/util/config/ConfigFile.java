/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.spongepowered.api.util.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

public class ConfigFile {

    private File file;
    private Config config;

    private ConfigFile(File file) {
        this.file = file;
        this.config = new Config(this.file);
    }

    public void set(String path, String value) {
        config.set(path, value);
    }

    public void save() {
        config.save();
    }

    public File getConfigFile() {
        return file;
    }

    public Object get(String path) {
        return config.get(path);
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public double getDouble(String path) {
        return config.getDouble(path);
    }

    public float getFloat(String path) {
        return config.getFloat(path);
    }

    private class Config {

        File file;
        BufferedReader is;
        OutputStream os;
        HashMap<String, Object> data;

        Config(File file) {
            try {
                this.file = file;
                this.is = new BufferedReader(new FileReader(this.file));
                this.os = new FileOutputStream(this.file);

                init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void set(String path, Object value) {
            data.put(path, value);
        }

        void save() {
            // TODO: Implement Tabs/Whitespaces
            try {
                for (Entry<String, Object> entry : data.entrySet()) {
                    String path = entry.getKey();
                    Object value = entry.getValue();

                    String s = path + ": " + value;
                    os.write(s.getBytes());
                }
                os.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void init() throws Exception {
            String line;
            while ((line = is.readLine()) != null) {
                line = line.trim();
                String[] kv = line.split(": ");
                if (kv.length == 0) {
                    kv = line.split(":");
                }

                if (kv.length == 2) {
                    data.put(kv[0], kv[1]);
                }
            }
        }

        Object get(String path) {
            return data.get(path);
        }

        String getString(String path) {
            Object s = data.get(path);
            if (s instanceof String) {
                return (String) s;
            }
            return "";
        }

        int getInt(String path) {
            Object i = data.get(path);
            if (i instanceof Integer) {
                return ((Integer) i).intValue();
            }
            return 0;
        }

        double getDouble(String path) {
            Object d = data.get(path);
            if (d instanceof Double) {
                return ((Double) d).doubleValue();
            }
            return 0.0;
        }

        float getFloat(String path) {
            Object f = data.get(path);
            if (f instanceof Float) {
                return ((Float) f).floatValue();
            }
            return 0;
        }

    }

}
