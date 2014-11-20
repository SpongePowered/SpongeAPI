package org.spongepowered.api.entity;

import org.spongepowered.api.entity.living.HumanEntity;

public interface Merchant {

    void setCustomer(HumanEntity human);

    HumanEntity getCustomer();


}
