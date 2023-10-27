package br.com.pazzini.singletons; // Pacote que contém a classe SingletonMap

import java.util.HashMap; // Importa a classe HashMap do Java
import java.util.Map; // Importa a interface Map do Java

public class SingletonMap { // Classe que implementa o padrão Singleton para um Map

    private static SingletonMap instance; // Instância estática de SingletonMap

    protected Map<Class, Map<Long, ?>> map; // Mapa que contém outra camada de mapa com tipos de chave longa e valores genéricos

    private SingletonMap() { // Construtor privado para impedir a criação de instâncias
        this.map = new HashMap<>(); // Inicializa o mapa como um novo HashMap
    }

    public static final SingletonMap getInstance() { // Método estático que retorna a instância SingletonMap
        if (instance == null) { // Verifica se a instância é nula
            instance = new SingletonMap(); // Se for nula, cria uma nova instância SingletonMap
        }
        return instance; // Retorna a instância SingletonMap
    }

    public Map<Class, Map<Long, ?>> getMap() { // Método que retorna o mapa
        return this.map; // Retorna o mapa atual
    }
}