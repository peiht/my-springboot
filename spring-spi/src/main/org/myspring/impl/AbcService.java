package org.myspring.impl;

import org.myspring.SpiService;

public class AbcService implements SpiService {
    @Override
    public String getName() {
        return "abc";
    }
}
