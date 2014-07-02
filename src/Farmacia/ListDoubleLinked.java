/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Farmacia;

/**
 *
 * @author TIAGO
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe ListDoubleLinked: implementa uma lista duplamente encadeada genÃ©rica
 * com sentinelas.
 *
 * @author Isabel Harb Manssour
 */
public class ListDoubleLinked<E>  {

    // ReferÃªncia para o sentinela de inÃ­cio da lista encadeada.
    private Node<E> header;
    // ReferÃªncia para o sentinela de fim da lista encadeada.
    private Node<E> trailer;
    // Contador do nÃºmero de elementos da lista.
    private int count;

    private class Node<T> {
        public T element;
        public Node<T> next;
        public Node<T> prev;
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public ListDoubleLinked() {
        header = new Node<>(null);
        trailer = new Node<>(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public Iterator<E> iterator() {
        return (new Iterator<E>() {
            private Node<E> current = header.next;
            @Override
            public boolean hasNext() {
                return current != trailer;
            }
            @Override
            public E next() {
                if (current == trailer) {
                    throw new NoSuchElementException();
                }
                E item = current.element;
                current = current.next;
                return item;
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(E element) {
        Node<E> n = new Node<>(element);
        Node<E> last = trailer.prev;
        n.prev = last;
        n.next = trailer;
        last.next = n;
        trailer.prev = n;
        count++;
    }

    /**
     * Insere um elemento em uma determinada posiÃ§Ã£o da lista
     * @param index a posiÃ§Ã£o da lista onde o elemento serÃ¡ inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        // Instancia o novo nodo
        Node<E> n = new Node<>(element);

        // Verifica se Ã© inserÃ§Ã£o no final
        if (index == count) {
            n.next = trailer;
            n.prev = trailer.prev;
            trailer.prev.next = n;
            trailer.prev = n;
        } else { // caso seja inserÃ§Ã£o no inÃ­cio ou no meio
            // Declara referencia auxilia para percorrer a lista
            Node<E> aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            n.next = aux;
            n.prev = aux.prev;
            aux.prev.next = n;
            aux.prev = n;
        }
        count++;
    }

    /**
     * Remove a primeira ocorrÃªncia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contÃ©m o elemento especificado
     */
    public boolean remove(E element) {
        Node<E> aux = header.next;

        for (int i = 0; i < count; i++) {
            if (element.equals(aux.element)) {
                // Se achou o elemento a ser removido, remove
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }

        return false;
    }

    /**
     * Remove o elemento de uma determinada posiÃ§Ã£o da lista
     * @param index a posiÃ§Ã£o da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> aux = header.next;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;

        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posiÃ§Ã£o da lista
     * @param index a posiÃ§Ã£o da lista
     * @return o elemento da posiÃ§Ã£o especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Node<E> aux = null;
        
        if (index < count/2) { // percorre do inicio para o fim
            aux = header.next;
            for(int i=0; i<index; i++) {
                aux = aux.next;
            }            
        }
        else { // percorre do fim para o inicio
            aux = trailer.prev;
            for(int i=count-1; i>index; i--)
                aux = aux.prev;
        }
        
        return aux.element;
    }

    /**
     * Retorna true se a lista contÃ©m o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contÃ©m o elemento especificado
     */
    public boolean contains(E element) {
        Node<E> aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return (true);
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o Ã­ndice da primeira ocorrÃªncia do elemento na lista, ou -1 se a
     * lista nÃ£o contÃ©m o elemento
     * @param element o elemento a ser buscado
     * @return o Ã­ndice da primeira ocorrÃªncia do elemento na lista, ou -1 se a
     * lista nÃ£o contÃ©m o elemento
     */
    public int indexOf(E element) {
        Node<E> aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posiÃ§Ã£o da lista pelo
     * elemento indicado
     * @param index a posiÃ§Ã£o da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posiÃ§Ã£o da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Node<E> aux = null;
        
        if (index < count/2) { // percorre do inicio para o fim
            aux = header.next;
            for(int i=0; i<index; i++) {
                aux = aux.next;
            }            
        }
        else { // percorre do fim para o inicio
            aux = trailer.prev;
            for(int i=count-1; i>index; i--)
                aux = aux.prev;
        }
        E elemAux = aux.element;
        aux.element = element;
        return elemAux;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node<>(null);
        trailer = new Node<>(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o nÃºmero de elementos da lista
     *
     * @return o nÃºmero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista nÃ£o contÃªm elementos
     *
     * @return true se a lista nÃ£o contÃªm elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }
}
    

