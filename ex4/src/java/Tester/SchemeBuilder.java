/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import javax.persistence.Persistence;

/**
 *
 * @author JoachimDittman
 */
public class SchemeBuilder {
     public static void main(String[] args) {
        Persistence.generateSchema("Exercise4PU", null);
    }
}
