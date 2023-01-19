package com.huskytacodile.alternacraft.entities.ai;

import com.huskytacodile.alternacraft.entities.Sleeping;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;

public class SleepingRandomLookAroundGoal <T extends Mob & Sleeping> extends RandomLookAroundGoal {
	
	T entity;
	
	public SleepingRandomLookAroundGoal(T entity) {
		super(entity);
		this.entity = entity;
	}
	
	public boolean canUse() {
		return super.canUse() && !entity.isAsleep();
	}
	
	public boolean canContinueToUse() {
		return super.canContinueToUse() && !entity.isAsleep();
	}

}
