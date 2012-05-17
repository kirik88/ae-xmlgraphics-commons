/*
 * Licensed to the Apache Software Foundation (ASF) under one or more

 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.xmlgraphics.java2d.ps;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import org.apache.xmlgraphics.java2d.GraphicContext;
import org.apache.xmlgraphics.ps.PSGenerator;
import org.apache.xmlgraphics.ps.PSState;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PSGraphics2DTestCase {

    private PSGenerator gen;
    private PSGraphics2D gfx2d;
    private final AffineTransform TRANSFORM = new AffineTransform(1, 0, 0, -1, 0, 792);

    @Before
    public void setup() {
        gen = mock(PSGenerator.class);
        createGraphics2D();
        PSState pState = new PSState();
        when(gen.getCurrentState()).thenReturn(pState);
    }

    private void createGraphics2D() {
        gfx2d = new PSGraphics2D(false, gen);
        gfx2d.setGraphicContext(new GraphicContext());
        gfx2d.setTransform(TRANSFORM);
    }

    @Test
    public void draw() throws IOException {
        assertEquals(gfx2d.getTransform(), TRANSFORM);
        gfx2d.draw(new Rectangle(10, 10, 100, 100));
        verify(gen, times(1)).concatMatrix(TRANSFORM);
    }
}
