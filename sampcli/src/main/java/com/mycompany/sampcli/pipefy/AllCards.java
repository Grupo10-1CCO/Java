/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.pipefy;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jambi
 */
public class AllCards {
    public List<Edges> edges;

    public List<Edges> getEdges() {
        return edges;
    }

    public void setEdges(List<Edges> edges) {
        this.edges = edges;
    }

  
    @Override
    public String toString() {
        return "Edges{" + "edges=" + edges + '}';
    }
}
