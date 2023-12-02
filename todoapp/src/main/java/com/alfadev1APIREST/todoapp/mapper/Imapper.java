/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alfadev1APIREST.todoapp.mapper;

/**
 *
 * @author cyka
 */
public interface Imapper <I, O> {
    public O map(I in);
}
