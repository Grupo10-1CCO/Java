/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.pipefy;

/**
 *
 * @author jambi
 */
public class Data {
    public AllCards allCards;


   

    public AllCards getAllCards() {
        return allCards;
    }

    public void setAllCards(AllCards allCards) {
        this.allCards = allCards;
    }
    
     @Override
    public String toString() {
        return "ResponsePipefy{" + "allCards=" + allCards + '}';
    }
}
