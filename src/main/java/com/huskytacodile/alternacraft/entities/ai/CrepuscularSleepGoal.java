package com.huskytacodile.alternacraft.entities.ai;

import com.huskytacodile.alternacraft.config.AlternacraftConfig;


import com.huskytacodile.alternacraft.entities.Sleeping;
import com.huskytacodile.alternacraft.entities.dinos.AlternaDinoEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

public class CrepuscularSleepGoal <T extends Mob & Sleeping & OwnableEntity> extends Goal {
	
	public T entity;
	
	public CrepuscularSleepGoal(T sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean canUse() {
		Level world = entity.level;
		return AlternacraftConfig.sleepingAi && (world.getDayTime() >= 2000 && world.getDayTime() <= 9000 || world.getDayTime() >= 14000 && world.getDayTime() <= 21000) && entity.getLastHurtByMob() == null && entity.getTarget() == null && entity.getOwner() == null && !entity.isInWater() && !entity.isInPowderSnow;
	}
	
	@Override
	public boolean canContinueToUse() {
		Level world = entity.level;
		if (world.getDayTime() <= 2000 || world.getDayTime() >= 9000 && world.getDayTime() <= 14000 || world.getDayTime() >= 21000 && world.getDayTime() <= 24000) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.getTarget() != null) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.getLastHurtByMob() != null) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.getOwner() != null) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.isInWater()) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.isInPowderSnow) {
			stop();
			entity.setAsleep(false);
			return false;
		} else return true;
	}
	
	public void tick() {
		super.tick();
		Level world = entity.level;
		if (world.getDayTime() <= 2000 || world.getDayTime() >= 9000 && world.getDayTime() <= 14000 || world.getDayTime() >= 21000 && world.getDayTime() <= 24000) {
			stop();
			entity.setAsleep(false);
		} else if (entity.getTarget() != null) {
			stop();
			entity.setAsleep(false);
		} else if (entity.getLastHurtByMob() != null) {
			stop();
			entity.setAsleep(false);
		} else entity.setAsleep(entity.getOwner() == null);
	}
	
	@Override
	public void start() {
		entity.setAsleep(true);
		if (entity instanceof AlternaDinoEntity dino) {
			dino.setNaturallySitting(false);
		}
		entity.getNavigation().stop();
	}
	
	@Override
	public void stop() {
		entity.setAsleep(false);
	}
	
}
