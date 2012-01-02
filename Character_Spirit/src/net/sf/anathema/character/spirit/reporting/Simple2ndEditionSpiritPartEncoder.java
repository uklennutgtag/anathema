package net.sf.anathema.character.spirit.reporting;

import net.sf.anathema.character.reporting.pdf.layout.simple.AbstractSecondEditionExaltPdfPartEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.general.NullBoxContentEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.general.box.IBoxContentEncoder;
import net.sf.anathema.lib.resources.IResources;

public class Simple2ndEditionSpiritPartEncoder extends AbstractSecondEditionExaltPdfPartEncoder {

  public Simple2ndEditionSpiritPartEncoder(IResources resources, int essenceMax) {
    super(resources);
  }

  // TODO: This should be properly edited out, not just nulled out.
  public IBoxContentEncoder getGreatCurseEncoder() {
    return new NullBoxContentEncoder();
  }

  @Override
  public IBoxContentEncoder getAnimaEncoder() {
    return new SpiritAnimaEncoderFactory(getResources()).createAnimaEncoder();
  }
}