package novoEu._controllers;

import novoEu._entidades.Alimento;
import novoEu._entidades.Dieta;
import novoEu._entidades.Usuario;

import java.io.*;
import java.util.*;

public class NovoEuController {
    private Map<String, Alimento> alimentosCadastrados;
    private Map<Integer, Usuario> usuariosCadastrados;
    private Map<String, Dieta> dietasCadastradas;
    private boolean statusSitema;

    public NovoEuController() {
        this.alimentosCadastrados = new HashMap<>();
        this.usuariosCadastrados = new HashMap<>();
        this.dietasCadastradas = new HashMap<>();
        this.statusSitema = false;
    }

    public void inicializaSistema() {
        this.lerArquivos();
        this.statusSitema = true;
    }

    public void finalizaSistema() {
        this.criaArquivos();
        this.statusSitema = false;
    }

    public String listaUsuarios() {
        this.verificaFuncionalidadeDoSistema();
        String saida = "";

        for (Usuario usuario: this.usuariosCadastrados.values()) {
            saida += usuario.toString() + " | ";
        }

        return saida.substring(0, saida.length() - 3);
    }

    public int adicionaUsuario(int id, String nome) {
        this.verificaFuncionalidadeDoSistema();
        this.usuariosCadastrados.put(id, new Usuario(id, nome));
        return this.usuariosCadastrados.get(id).getId();
    }

    public void cadastraDieta(String nomeDieta, String alimentos) {
        this.verificaFuncionalidadeDoSistema();
        List<Alimento> alimentoList = this.cadastroAlimentos(alimentos);

        this.dietasCadastradas.put(nomeDieta.trim().toLowerCase(), new Dieta(nomeDieta, alimentoList));
    }
    public void setDietaUsuario(int idUsuario, String dieta) {
        this.verificaFuncionalidadeDoSistema();
        this.usuariosCadastrados.get(idUsuario).setDieta(this.dietasCadastradas.get(dieta.trim().toLowerCase()));
    }

    public int comeAlimento(int idUsuario, String alimento) {
         this.verificaFuncionalidadeDoSistema();
         return this.usuariosCadastrados.get(idUsuario).comeAlimento(this.alimentosCadastrados.get(alimento.trim().toLowerCase()));
    }

    private List<Alimento> cadastroAlimentos(String alimentos) {
        String[] alimentosArray = alimentos.split(" ");
        List<Alimento> alimentoList = new ArrayList<>();

        for (String alimento : alimentosArray) {
            if (!this.alimentosCadastrados.containsKey(alimento.trim().toLowerCase())) {
                Alimento alimentoCadastro = new Alimento(alimento);
                this.alimentosCadastrados.put(alimento.trim().toLowerCase(), alimentoCadastro);
                alimentoList.add(this.alimentosCadastrados.get(alimento.trim().toLowerCase()));
            } else {
                alimentoList.add(this.alimentosCadastrados.get(alimento.trim().toLowerCase()));
            }
        }

        return alimentoList;
    }

    private void verificaFuncionalidadeDoSistema() {
        if (this.statusSitema == false) {
            throw new RuntimeException("Sistema não foi inicializado antes");
        }
    }

    private void lerArquivos() {
        ObjectInputStream oisAlimentos = null;
        ObjectInputStream oisUsuarios = null;
        ObjectInputStream oisDietas = null;

        try {
            oisAlimentos = new ObjectInputStream(new FileInputStream("alimentos.dat"));
            oisUsuarios = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            oisDietas = new ObjectInputStream(new FileInputStream("dietas.dat"));

            Map<String, Alimento> alimentosCadastrados = (HashMap<String, Alimento>) oisAlimentos.readObject();
            Map<Integer, Usuario> usuariosCadastros = (HashMap<Integer, Usuario>) oisUsuarios.readObject();
            Map<String, Dieta> dietasCadastradas = (HashMap<String, Dieta>)  oisDietas.readObject();

            this.alimentosCadastrados = alimentosCadastrados;
            this.usuariosCadastrados = usuariosCadastros;
            this.dietasCadastradas = dietasCadastradas;

        } catch (IOException e) {
            this.criaArquivos();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void criaArquivos() {
        ObjectOutputStream oosAlimentosI = null;
        ObjectOutputStream oosUsuariosI = null;
        ObjectOutputStream oosDietasI = null;

        try {
            oosAlimentosI = new ObjectOutputStream(new FileOutputStream("alimentos.dat"));
            oosUsuariosI = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            oosDietasI = new ObjectOutputStream(new FileOutputStream("dietas.dat"));

            oosAlimentosI.writeObject(this.alimentosCadastrados);
            oosDietasI.writeObject(this.dietasCadastradas);
            oosUsuariosI.writeObject(this.usuariosCadastrados);
            this.inicializaSistema();

        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
