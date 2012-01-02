package net.sf.anathema.character.lunar.reporting.layout;

import net.sf.anathema.character.lunar.reporting.rendering.anima.LunarAnimaEncoderFactory;
import net.sf.anathema.character.lunar.reporting.rendering.greatcurse.SecondEditionLunarGreatCurseEncoder;
import net.sf.anathema.character.reporting.pdf.layout.simple.AbstractSecondEditionExaltPdfPartEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.boxes.BoxContentEncoderRegistry;
import net.sf.anathema.character.reporting.pdf.rendering.general.box.IBoxContentEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.page.IPdfPageEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.page.PdfPageConfiguration;
import net.sf.anathema.lib.resources.IResources;

public class Simple2ndEditionLunarPartEncoder extends AbstractSecondEditionExaltPdfPartEncoder {

  private BoxContentEncoderRegistry encoderRegistry;

  public Simple2ndEditionLunarPartEncoder(BoxContentEncoderRegistry encoderRegistry, IResources resources, int essenceMax) {
    super(resources);
    this.encoderRegistry = encoderRegistry;
  }

  public IBoxContentEncoder getGreatCurseEncoder() {
    return new SecondEditionLunarGreatCurseEncoder();
  }

  @Override
  public IBoxContentEncoder getAnimaEncoder() {
    return new LunarAnimaEncoderFactory(getResources()).createAnimaEncoder();
  }

  @Override
  public IPdfPageEncoder[] getAdditionalPages(PdfPageConfiguration configuration) {
    return new IPdfPageEncoder[] { new Lunar2ndEditionAdditionalPageEncoder(encoderRegistry, this, getResources(), configuration) };
  }
}