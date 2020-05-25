package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.cpnv.angrybob3.Models.Data.Word;


import java.util.ArrayList;

/**
 * Created by Phil & XCL
 */

public final class Scenery {

    private ArrayList<PhysicalObject> scene;
    private ArrayList<Pig> pigs;

    public Scenery() {
        scene = new ArrayList<PhysicalObject>();
        pigs = new ArrayList<Pig>();
    }

    public void addElement (PhysicalObject po) throws Exception
    {
        for (PhysicalObject o : scene)
            if (po.collidesWith(o))
                throw new Exception("Collision !!!!");
        scene.add(po);
        if (po.getClass().equals(Pig.class))
            pigs.add((Pig)po);
    }

    public void draw(Batch batch)
    {
        for (PhysicalObject p : scene) p.draw(batch);
    }

    /**
     * Returns the object of the scenary that object o has hit (null if none)
     * @param o
     * @return
     */
    public PhysicalObject collidesWith(PhysicalObject o)
    {
        for (PhysicalObject po : scene)
            if (po.collidesWith(o))
                return po;
        return null;
    }

    /**
     * Returns the pig at the given location - if any (null if none)
     *
     * @param x
     * @param y
     * @return
     */
    public Pig pigTouched(float x, float y)
    {
        for (PhysicalObject po : scene)
            if (po.getClass().equals(Pig.class))
                if (po.getRectangle().contains(x,y))
                    return (Pig)po;
        return null;
    }

    /**
     *  A smart scenery is capable of returning one of the words that is hidden in one of its pigs
     * @return
     */
    public Word pickAWord()
    {
        //return pigs.get(AngryBob.random.nextInt(pigs.size())).getWord();
        return new Word(1,"bob", "bob");
    }
}
