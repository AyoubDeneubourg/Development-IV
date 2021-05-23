package Patterns.Strategy;

import Interfaces.SoundBehavior;

public class Grill implements SoundBehavior {
    @Override
    public void eat() {
        System.out.println("Crunch crunch!");
    }
}
