package net.sf.anathema.character.main.equipment;

public interface HeroStatsModifiers {

  int getMobilityPenalty();

  int getDDVPoolMod();

  int getMDDVPoolMod();

  int getMPDVPoolMod();

  int getJoinBattleMod();

  int getJoinDebateMod();

  int getJoinWarMod();
}