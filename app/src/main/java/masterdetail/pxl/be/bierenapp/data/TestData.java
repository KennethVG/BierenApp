package masterdetail.pxl.be.bierenapp.data;

import java.util.ArrayList;
import java.util.List;

import masterdetail.pxl.be.bierenapp.model.Bier;

import static masterdetail.pxl.be.bierenapp.model.Soort.*;

/**
 * Created by vangike on 20/01/2017.
 */

public class TestData {

    private List<Bier> bieren;

    public TestData() {
        bieren = new ArrayList<>();
        testdata();
    }

    private void testdata() {
        bieren.add(new Bier("Grimbergen Blond", BLOND, 6.7, "Smaak: Grimbergen Blond is licht fruitig en evenwichtig zoet-bitter. Door zijn uitgesproken volronde smaak wordt dit bier ten zeerste geapprecieerd."));
        bieren.add(new Bier("Grimbergen Dubbel", BRUIN, 6.5, "Smaak: Grimbergen Dubbel is een zoet-bitter bier met veel volheid en toetsen van karamel. Het is een heel rijk bier met dubbele gisting waarvan u optimaal kan genieten in uw vrije tijd."));
        bieren.add(new Bier("Grimbergen Tripel", OKER, 9.0, "Smaak: Grimbergen Tripel heeft een bitter-zoete, pittige en uiterst volronde smaak. De typische pittige tripelsmaak ontstaat door de blonde kandijsuiker en de subtiele mengeling van zachte en bittere hopsoorten. De nagisting op fles tenslotte geeft het smaakboeket een perfecte harmonie. U zal vooral de warme afdronk van dit bier weten te appreciëren. "));
        bieren.add(new Bier("Grimbergen Goud", GOUD, 8.0, "Smaak: Het traditionele Grimbergenrecept is bij Grimbergen Goud verrijkt door het gebruik van aromatische hop, wat het bier zijn verfijnde bitterheid en hoppig karakter geeft. Een prachtig resultaat voor al wie een sterk blond bier kan waarderen.  "));
        bieren.add(new Bier("Stella Artois", BLOND, 5.2, "Stella Artois is een Belgische pils, gebrouwen in Leuven, en valt onder het concern AB InBev. Het heeft een alcoholpercentage van 5.2%. Het bier ontstond in 1926, toen het als 'kerstbier' onder de naam Stella (Latijn voor Ster) op de markt werd gebracht. Het recept is sindsdien geregeld gewijzigd waardoor het bier met name in de laatste jaren aanzienlijk minder bitter is geworden.  "));
    }

    public List<Bier> getBieren() {
        return bieren;
    }
}
