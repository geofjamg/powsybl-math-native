/**
 * Copyright (c) 2023, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.math;

import org.scijava.nativelib.NativeLoader;

import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * @author Geoffroy Jamgotchian {@literal <geoffroy.jamgotchian at rte-france.com>}
 */
public class MathNative {

    private static boolean INIT = false;

    private static native void nativeInit();

    static {
        if (!INIT) {
            try {
                NativeLoader.loadLibrary("math");
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            nativeInit();
            INIT = true;
        }
    }
}