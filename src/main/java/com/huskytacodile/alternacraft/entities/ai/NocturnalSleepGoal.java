package com.huskytacodile.alternacraft.entities.ai;

import com.huskytacodile.alternacraft.config.AlternacraftConfig;
import com.huskytacodile.alternacraft.entities.Sleeping;
import com.huskytacodile.alternacraft.entities.dinos.AlternaDinoEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

public class NocturnalSleepGoal <T extends Mob & Sleeping & OwnableEntity> extends Goal {
	
	public T entity;
	
	public NocturnalSleepGoal(T sleeper) {
		super();
		this.entity = sleeper;
	}
	
	@Override
	public boolean canUse() {
		Level world = entity.level;
		return AlternacraftConfig.sleepingAi && world.getDayTime() >= 0 && world.getDayTime() <= 12000 && entity.getLastHurtByMob() == null && entity.getTarget() == null && entity.getOwner() == null && !entity.isInPowderSnow && !entity.isInWater();
	}
	
	@Override
	public boolean canContinueToUse() {
		Level world = entity.level;
		if (world.getDayTime() >= 12000 && world.getDayTime() < 24000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.getOwner() != null || entity.isInPowderSnow || entity.isInWater()) {
			stop();
			return false;
		} else return true;
	}
	
	@Override
	public void start() {
		entity.setAsleep(true);
		if (entity instanceof AlternaDinoEntity dino) {
			dino.setNaturallySitting(false);
		}
		entity.getNavigation().stop();
	}
	
	public void tick() {
		super.tick();
		Level world = entity.level;
		if (world.getDayTime() >= 12000 && world.getDayTime() < 24000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.getOwner() != null || entity.isInPowderSnow || entity.isInWater()) {
			stop();
		}
	}
	
	@Override
	public void stop() {
		entity.setAsleep(false);
	}

}
