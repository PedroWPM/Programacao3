// Classe Animal
public abstract class Animal {
    // Método abstrato para emitir som
    public abstract void emitirSom();
}

// Subclasse Cachorro
public class Cachorro extends Animal {
    // Sobrescrevendo o método emitirSom para Cachorro
    @Override
    public void emitirSom() {
        System.out.println("Au Au!");
    }
}

// Subclasse Gato
public class Gato extends Animal {
    // Sobrescrevendo o método emitirSom para Gato
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
}

// Classe principal para testar a funcionalidade
public class Main {
    public static void main(String[] args) {
        // Criando um array de Animal com Cachorro e Gato
        Animal[] animais = new Animal[2];
        animais[0] = new Cachorro();
        animais[1] = new Gato();

        // Percorrendo o array e chamando emitirSom() para cada animal
        for (Animal animal : animais) {
            animal.emitirSom();
        }
    }
}
