package com.huskytacodile.alternacraft.entities.ai;

import com.huskytacodile.alternacraft.config.AlternacraftConfig;


import com.huskytacodile.alternacraft.entities.dinos.AlternaDinoEntity;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

public class CrepuscularSleepGoal extends Goal {
	
	public AlternaDinoEntity entity;
	
	public CrepuscularSleepGoal(AlternaDinoEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean canUse() {
		Level world = entity.level;
		if (AlternacraftConfig.sleepingAi = true && (world.getDayTime() >= 2000 && world.getDayTime() <= 9000 || world.getDayTime() >= 14000 && world.getDayTime() <= 21000) && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isTame() && !entity.isInWater() && !entity.isInPowderSnow) {
			return true;
		} else {
			return false;
		}
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
		} else if (entity.isTame()) {
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
		} else if (entity.isTame()) {
			entity.setAsleep(false);
		}else {
			entity.setAsleep(true);
		}
	}
	
	@Override
	public void start() {
		entity.setAsleep(true);
		entity.setNaturallySitting(false);
		entity.getNavigation().stop();
	}
	
	@Override
	public void stop() {
		entity.setAsleep(false);
	}
	
}
