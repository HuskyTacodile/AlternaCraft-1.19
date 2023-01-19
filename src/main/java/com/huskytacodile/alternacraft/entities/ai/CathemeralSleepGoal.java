package com.huskytacodile.alternacraft.entities.ai;

import com.huskytacodile.alternacraft.config.AlternacraftConfig;
import com.huskytacodile.alternacraft.entities.Sleeping;
import com.huskytacodile.alternacraft.entities.dinos.AlternaDinoEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class CathemeralSleepGoal <T extends Mob & Sleeping & OwnableEntity> extends Goal {
	
	public T entity;
	private int sleepTimer;
	
	public CathemeralSleepGoal(T sleeper) {
		super();
		this.entity = sleeper;
	}
	
	@Override
	public boolean canUse() {
		return entity.isOnGround() && AlternacraftConfig.sleepingAi && entity.getRandom().nextInt(1000) == 0 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInPowderSnow && !entity.isInWater() && entity.getOwner() == null;
	}
	
	@Override
	public boolean canContinueToUse() {
		if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || !super.canContinueToUse() || entity.isInWater() || entity.isInPowderSnow || entity.getTarget() != null || entity.getOwner() != null) {
			stop();
			return false;
		} else return true;
	}
	
	public void tick() {
		super.tick();
		sleepTimer++;
		if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInPowderSnow || entity.getOwner() != null) {
			stop();
		}
	}
	
	@Override
	public void start() {
		sleepTimer = 0;
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
