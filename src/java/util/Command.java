/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author G0042204
 */
public abstract class Command {

    public abstract void exec();

    public void command() {
        try {
            this.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
