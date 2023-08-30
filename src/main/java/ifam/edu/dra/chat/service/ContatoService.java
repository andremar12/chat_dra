package ifam.edu.dra.chat.service;

import ifam.edu.dra.chat.model.Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    List<Contato> contatos = new ArrayList<>();

    public List<Contato> getContatos(){
        return contatos;
    }


    public Contato getContato(int id){
        return contatos.get(id);
    }

    public void setContato(Contato contato) {
        contatos.add(contato);
    }

    public void setContato(int id, Contato contato) {
        contatos.set(id, contato);
    }

    public void deleteContato(int id) {
        contatos.remove(id);
    }

}