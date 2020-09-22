package com.cpnv.angrybob3.Providers;

import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Data.Vocabulary;
import com.cpnv.angrybob3.Models.Data.Word;

import java.util.ArrayList;

public class VocProvider {

    private static VocProvider songle_instance = null;

    public ArrayList<Vocabulary> vocs;

    private VocProvider(){
        vocs = new ArrayList<Vocabulary>();
        Word word;
        Vocabulary vocabulary = new Vocabulary("L'argent");
        word = new Word("Money Money!","argent"); vocabulary.addWord(word);
        word = new Word("la banque","the bank"); vocabulary.addWord(word);
        word = new Word("l''argent liquide","cash"); vocabulary.addWord(word);
        word = new Word("le paiement","payment"); vocabulary.addWord(word);
        word = new Word("un carnet de chèques","checkbook"); vocabulary.addWord(word);
        word = new Word("déposer de l''argent","to deposit money"); vocabulary.addWord(word);
        word = new Word("prêter de l''argent","to borrow money"); vocabulary.addWord(word);
        word = new Word("les services financiers","financial services"); vocabulary.addWord(word);
        word = new Word("la commission","commission"); vocabulary.addWord(word);
        word = new Word("un investissement","an investment"); vocabulary.addWord(word);
        word = new Word("un virement","transfer"); vocabulary.addWord(word);
        word = new Word("la gestion de l''argent","money management"); vocabulary.addWord(word);
        word = new Word("une transaction","a transaction"); vocabulary.addWord(word);
        word = new Word("un guichet automatique","ATM machine"); vocabulary.addWord(word);
        word = new Word("attendre dans la queue","to wait in line"); vocabulary.addWord(word);
        word = new Word("une carte bancaire","banking/ATM card"); vocabulary.addWord(word);
        word = new Word("faire des économies","to save money"); vocabulary.addWord(word);
        word = new Word("le montant","sum/total amount"); vocabulary.addWord(word);
        word = new Word("un compte-chèques","checking account"); vocabulary.addWord(word);
        word = new Word("l''argent","money"); vocabulary.addWord(word);
        word = new Word("les fonds","funds"); vocabulary.addWord(word);
        word = new Word("un chèque","check"); vocabulary.addWord(word);
        word = new Word("un dépôt","deposit"); vocabulary.addWord(word);
        word = new Word("le crédit","credit"); vocabulary.addWord(word);
        word = new Word("les marchés financiers","financial markets"); vocabulary.addWord(word);
        word = new Word("la clientèle","clientele"); vocabulary.addWord(word);
        word = new Word("les frais","fees"); vocabulary.addWord(word);
        word = new Word("une institution financière","financial institution"); vocabulary.addWord(word);
        word = new Word("le taux d''intérêt","interest rate"); vocabulary.addWord(word);
        word = new Word("la monnaie","currency"); vocabulary.addWord(word);
        word = new Word("le bilan","balance"); vocabulary.addWord(word);
        word = new Word("prendre un numéro","to take a number"); vocabulary.addWord(word);
        word = new Word("une carte de crédit","credit card"); vocabulary.addWord(word);
        word = new Word("un emprunt","a loan"); vocabulary.addWord(word);
        word = new Word("retirer de l''argent","to take out money"); vocabulary.addWord(word);
        word = new Word("un compte d''épargne","savings account"); vocabulary.addWord(word);
        word = new Word("un distributeur automatique","ATM machine"); vocabulary.addWord(word);
        word = new Word("un reçu","receipt"); vocabulary.addWord(word);
        vocs.add(vocabulary);

        vocabulary = new Vocabulary("Le Mobilier");
        word = new Word("une table","a table"); vocabulary.addWord(word);
        word = new Word("une chaise","a chair"); vocabulary.addWord(word);
        word = new Word("une bibliothèque","a bookcase"); vocabulary.addWord(word);
        word = new Word("une table basse","a coffee table"); vocabulary.addWord(word);
        word = new Word("une cheminée","a fireplace"); vocabulary.addWord(word);
        word = new Word("une table de chevet","a bedside table"); vocabulary.addWord(word);
        word = new Word("une étagère","a shelf"); vocabulary.addWord(word);
        word = new Word("une armoire","a wardrobe"); vocabulary.addWord(word);
        word = new Word("une commode","a dresser"); vocabulary.addWord(word);
        word = new Word("une moquette","a carpet"); vocabulary.addWord(word);
        word = new Word("un siège","a seat"); vocabulary.addWord(word);
        word = new Word("un tabouret","a stool"); vocabulary.addWord(word);
        word = new Word("un placard","a cupboard"); vocabulary.addWord(word);
        word = new Word("un tiroir","a drawer"); vocabulary.addWord(word);
        word = new Word("un fauteuil","a armchair"); vocabulary.addWord(word);
        word = new Word("un lit","a bed"); vocabulary.addWord(word);
        word = new Word("un bureau","a desk"); vocabulary.addWord(word);
        word = new Word("un miroir","a mrror"); vocabulary.addWord(word);
        word = new Word("un meuble","a piece of furniture"); vocabulary.addWord(word);
        word = new Word("un oreiller","a pillow"); vocabulary.addWord(word);
        vocs.add(vocabulary);

        vocabulary = new Vocabulary("Les Couleurs");
        word = new Word("blanc","white"); vocabulary.addWord(word);
        word = new Word("bleu clair","light blue"); vocabulary.addWord(word);
        word = new Word("multicolore","muli-colored"); vocabulary.addWord(word);
        word = new Word("gris","grey"); vocabulary.addWord(word);
        word = new Word("vert","green"); vocabulary.addWord(word);
        word = new Word("noir","black"); vocabulary.addWord(word);
        word = new Word("argenté","silver"); vocabulary.addWord(word);
        word = new Word("jaune","yellow"); vocabulary.addWord(word);
        word = new Word("orange","orange"); vocabulary.addWord(word);
        word = new Word("bleu","blue"); vocabulary.addWord(word);
        word = new Word("bleu foncé","dark blue"); vocabulary.addWord(word);
        word = new Word("rose","pink"); vocabulary.addWord(word);
        word = new Word("rouge","red"); vocabulary.addWord(word);
        word = new Word("marron","brown"); vocabulary.addWord(word);
        word = new Word("violet","purple"); vocabulary.addWord(word);
        word = new Word("beige","beige"); vocabulary.addWord(word);
        word = new Word("turquoise","turquoise"); vocabulary.addWord(word);
        word = new Word("doré","golden"); vocabulary.addWord(word);
        vocs.add(vocabulary);

        vocabulary = new Vocabulary("La Famille");
        word = new Word("le père","the father"); vocabulary.addWord(word);
        word = new Word("les parents","the parents"); vocabulary.addWord(word);
        word = new Word("la sœur","the sister"); vocabulary.addWord(word);
        word = new Word("la fille","the daughter"); vocabulary.addWord(word);
        word = new Word("le bébé","the baby"); vocabulary.addWord(word);
        word = new Word("la femme","the wife"); vocabulary.addWord(word);
        word = new Word("la fiancée","the fiancée"); vocabulary.addWord(word);
        word = new Word("la grand-mère","the grandmother"); vocabulary.addWord(word);
        word = new Word("les petits-enfants","the grandchildren"); vocabulary.addWord(word);
        word = new Word("la tante","the aunt"); vocabulary.addWord(word);
        word = new Word("la nièce","the niece"); vocabulary.addWord(word);
        word = new Word("la belle-mère","the step mother"); vocabulary.addWord(word);
        word = new Word("la cousine","the cousin (female)"); vocabulary.addWord(word);
        word = new Word("la belle-sœur","sister in-law"); vocabulary.addWord(word);
        word = new Word("la mère","the mother"); vocabulary.addWord(word);
        word = new Word("le frère","the brother"); vocabulary.addWord(word);
        word = new Word("le fils","the son"); vocabulary.addWord(word);
        word = new Word("l’enfant","the child"); vocabulary.addWord(word);
        word = new Word("le mari","the husband"); vocabulary.addWord(word);
        word = new Word("le fiancé","the fiancé"); vocabulary.addWord(word);
        word = new Word("le grand-père","the grandfather"); vocabulary.addWord(word);
        word = new Word("les grand-parents","the grandparents"); vocabulary.addWord(word);
        word = new Word("l’oncle","the uncle"); vocabulary.addWord(word);
        word = new Word("le neveu","the nephew"); vocabulary.addWord(word);
        word = new Word("le beau-père","the step father"); vocabulary.addWord(word);
        word = new Word("le cousin","the cousin (male)"); vocabulary.addWord(word);
        word = new Word("le beau-frère","brother in-law"); vocabulary.addWord(word);
        word = new Word("le beau-père","father in-law"); vocabulary.addWord(word);
        vocs.add(vocabulary);
    }

    public static VocProvider getInstance(){
        if (songle_instance == null)
            songle_instance = new VocProvider();
        return songle_instance;
    }

    public Vocabulary pickVoc() {
        return vocs.get(AngryBob.random.nextInt(vocs.size()));
    }
}
