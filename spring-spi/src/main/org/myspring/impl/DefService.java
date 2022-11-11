package org.myspring.impl;

import org.myspring.SpiService;

public class DefService implements SpiService {
    @Override
    public String getName() {
        return "def";
    }
}
