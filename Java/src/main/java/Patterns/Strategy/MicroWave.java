package Patterns.Strategy;

import Interfaces.SoundBehavior;

public class MicroWave implements SoundBehavior {
    @Override
    public void eat() {
        System.out.println("Miam miam!");
    }
}
