package org.spongepowered.api.entity.living.villager;

import java.util.List;

public interface VillagerFactory {

    Career getCareerFromName(String name);

    Profession getProfessionFromName(String name);

    Profession getProfessionFromCareer(Career career);

    List<Profession> getProfessions();

    List<Career> getCareers();

}
