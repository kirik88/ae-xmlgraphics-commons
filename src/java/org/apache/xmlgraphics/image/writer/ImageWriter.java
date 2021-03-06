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

/* $Id: ImageWriter.java 734420M 2012-05-15 08:52:01Z (local) $ */

package org.apache.xmlgraphics.image.writer;

import ae.java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Interface which allows image library independent image writing.
 *
 * @version $Id: ImageWriter.java 734420M 2012-05-15 08:52:01Z (local) $
 */
public interface ImageWriter {

    /**
     * Encodes an image and writes it to an OutputStream.
     * @param image the image to be encoded
     * @param out the OutputStream to write to
     * @throws IOException In case of an /IO problem
     */
    public void writeImage(RenderedImage image, OutputStream out)
            throws IOException;

    /**
     * Encodes an image and writes it to an OutputStream.
     * @param image the image to be encoded
     * @param out the OutputStream to write to
     * @param params a parameters object to customize the encoding.
     * @throws IOException In case of an /IO problem
     */
    public void writeImage(RenderedImage image, OutputStream out,
            ImageWriterParams params)
            throws IOException;

    /** @return the target MIME type supported by this ImageWriter */
    public String getMIMEType();

    /** @return true if the ImageWriter is expected to work properly in the current environment */
    public boolean isFunctional();

    /** @return true if the implemented format supports multiple pages in a single file */
    public boolean supportsMultiImageWriter();

    /**
     * Creates a MultiImageWriter instance that lets you put multiple pages into a single file
     * if the format supports it.
     * @param out the OutputStream to write the image to
     * @return the requested MultiImageWriter instance
     * @throws IOException In case of an /IO problem
     */
    public MultiImageWriter createMultiImageWriter(OutputStream out) throws IOException;

}
