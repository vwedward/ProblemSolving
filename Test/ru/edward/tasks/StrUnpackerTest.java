/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrUnpackerTest {

    @Test
    void unpackStr() {
        String resStr = StrUnpacker.unpackStr("3[xyz]4[xy]z");
        assertEquals(resStr, "xyzxyzxyzxyxyxyxyz");
    }
}