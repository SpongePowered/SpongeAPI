package org.spongepowered.api.entity.living.villager;

import java.util.List;

public class NullVillagerFactory implements VillagerFactory {

    @Override
    public Career getCareerFromName(String name) {
        return null;
    }

    @Override
    public Profession getProfessionFromName(String name) {
        return null;
    }

    @Override
    public Profession getProfessionFromCareer(Career career) {
        return null;
    }

    @Override
    public List<Profession> getProfessions() {
        return null;
    }

    @Override
    public List<Career> getCareers() {
        return null;
    }
}
