/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.pipefy;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author jambi
 */
public class Edges {
    public Node node;

    public Edges(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
    
    @Override
    public String toString() {
        return "Edges{" + "node=" + node + '}';
    }
}
