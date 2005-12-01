// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;

import org.freehep.util.io.Tag;

/**
 * RoundRect TAG.
 *
 * @author Mark Donszelmann
 * @version $Id: freehep-graphicsio-emf/src/main/java/org/freehep/graphicsio/emf/RoundRect.java eabe3cff0ec9 2005/12/01 22:52:56 duns $
 */
public class RoundRect
    extends EMFTag {

    private Rectangle bounds;
    private Dimension corner;

    RoundRect() {
        super(44, 1);
    }

    public RoundRect(Rectangle bounds, Dimension corner) {
        this();
        this.bounds = bounds;
        this.corner = corner;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len) 
        throws IOException {
    
        RoundRect tag = new RoundRect(emf.readRECTL(), emf.readSIZEL());
        return tag;
    }
    
    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeRECTL(bounds);
        emf.writeSIZEL(corner);
    }

    public String toString() {
        return super.toString()+"\n"+
            "  bounds: "+bounds+"\n"+
            "  corner: "+corner;
    }       
}
