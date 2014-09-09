/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.event;

/**
 * Order that a {@link SpongeEventHandler} may be registered at.<br>
 * <br>
 * Event handlers are called the order given in the following table.<br>
 * <br>
 * <table summary="Order Recommendations">
 *   <tr><td>Order</td>     <td>Read Only</td><td>Cancellation Allowed</td><td>Recommendation</td></tr>
 *   <tr><td>PRE</td>         <td>YES</td>             <td>NO</td>         <td>Initialisation and registration actions</td></tr>
 *   <tr><td>AFTER_PRE</td>   <td>YES</td>             <td>NO</td>         <td>Immediate responses to actions in PRE</td></tr>
 *   <tr><td>FIRST</td>       <td>YES</td>             <td>YES</td>        <td>Cancellation by protection plugins for informational purposes</td></tr>
 *   <tr><td>EARLY</td>       <td>NO</td>              <td>YES</td>        <td>Standard actions that should happen before other plugins react to the event</td></tr>
 *   <tr><td>DEFAULT</td>     <td>NO</td>              <td>YES</td>        <td>The default action order</td></tr>
 *   <tr><td>LATE</td>        <td>NO</td>              <td>YES</td>        <td>Standard actions that should happen after other plugins react to the event</td></tr>
 *   <tr><td>LAST</td>        <td>YES</td>             <td>YES</td>        <td>Final cancellation by protection plugins</td></tr>
 *   <tr><td>BEFORE_POST</td> <td>YES</td>             <td>YES</td>        <td>Actions that need to respond to cancelled events before POST</td></tr>
 *   <tr><td>POST</td>        <td>YES</td>             <td>YES</td>        <td>Actions that need to react to the final and stable effects of event</td></tr>
 * </table>
 */
public enum Order {
    PRE,
    AFTER_PRE,
    FIRST,
    EARLY,
    DEFAULT,
    LATE,
    LAST,
    BEFORE_POST,
    POST
}