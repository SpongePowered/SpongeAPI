package org.spongepowered.api;

import com.google.common.base.Optional;
import org.junit.Test;
import org.spongepowered.api.component.*;

import java.util.*;

public class ComponentTest {
    @Test
    public void testComponent() {

    }
}

class TestObject {}

class TestManager implements ComponentManager<TestObject> {
    @Override
    public <S extends ComponentSystem<TestObject>> S addSystem(S instance) {
        return null;
    }

    @Override
    public <S extends ComponentSystem<TestObject>> S addSystem(S instance, Class<S> clazz) {
        return null;
    }

    @Override
    public <S extends ComponentSystem<TestObject>> Optional<S> getSystem(Class<S> clazz) {
        return null;
    }

    @Override
    public <S extends ComponentSystem<TestObject>> Optional<S> removeSystem(Class<S> clazz) {
        return null;
    }

    @Override
    public <C extends Component> C addComponent(TestObject holder, C instance) {
        return null;
    }

    @Override
    public <C extends Component> C addComponent(TestObject holder, C instance, Class<C> clazz) {
        return null;
    }

    @Override
    public <C extends Component> Optional<C> getComponent(TestObject holder, Class<C> clazz) {
        return null;
    }

    @Override
    public boolean hasComponent(TestObject holder, Class<? extends Component> clazz) {
        return false;
    }

    @Override
    public <C extends Component> Optional<C> removeComponent(TestObject holder, Class<C> clazz) {
        return null;
    }
}

class TestSystem implements ComponentSystem<TestObject> {

    @Override
    public Filter getFilter() {
        return null;
    }

    @Override
    public boolean shouldProcess() {
        return false;
    }

    @Override
    public boolean offer(TestObject holder) {
        return false;
    }

    @Override
    public void preProcess() {
    }

    @Override
    public void process(TestObject holder, float dt) {
    }

    @Override
    public void postProcess() {
    }

    @Override
    public Collection<TestObject> getAll() {
        return null;
    }
}

class AComponent implements Component {
    public int a() {
        return 5;
    }
}

class BComponent implements Component {
    public int b() {
        return 5;
    }
}

class CComponent implements Component {
    public int c() {
        return 6;
    }
}
