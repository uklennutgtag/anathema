package net.sf.anathema.character.main.magic.parser;

import net.sf.anathema.character.main.magic.model.charm.ICharmXMLConstants;
import net.sf.anathema.character.main.magic.model.charm.CharmException;
import net.sf.anathema.character.main.magic.model.charm.duration.IDuration;
import net.sf.anathema.character.main.magic.model.charm.duration.QualifiedAmountDuration;
import net.sf.anathema.character.main.magic.model.charm.duration.SimpleDuration;
import net.sf.anathema.character.main.magic.model.charm.duration.UntilEventDuration;
import net.sf.anathema.lib.exception.PersistenceException;
import net.sf.anathema.lib.xml.ElementUtilities;
import org.dom4j.Element;

public class DurationBuilder {

  public IDuration buildDuration(Element durationElement) throws PersistenceException {
    if (durationElement == null) {
      throw new CharmException("Duration not specified for Charm");
    }
    String durationString = durationElement.attributeValue(ICharmXMLConstants.ATTRIB_DURATION);
    if (durationString != null) {
      return SimpleDuration.getDuration(durationString);
    }
    String amount = durationElement.attributeValue(ICharmXMLConstants.ATTRIB_AMOUNT);
    if (amount != null) {
      String unit = ElementUtilities.getRequiredAttrib(durationElement, ICharmXMLConstants.ATTRIB_UNIT);
      return new QualifiedAmountDuration(amount, unit);
    }
    String event = durationElement.attributeValue(ICharmXMLConstants.ATTRIB_EVENT);
    if (event != null) {
      return new UntilEventDuration(event);
    }
    throw new PersistenceException("No legal duration definition found");
  }
}