package edu.leon;

import edu.leon.model.Categoria;
import edu.leon.respositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private CategoriasRepository categoriasRepo;
    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        guardar();
//        buscarPorId(10);
        //modificar(2);
        //eliminar(1);
//        conteo();
        findAllById();
    }

    private void guardar() {
       Categoria categoria = new Categoria();
       categoria.setNombre("Finanzas");
       categoria.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
       categoriasRepo.save(categoria);
        System.out.println(categoria);
    }

    private void buscarPorId(Integer id) {
        Optional<Categoria> categoria = categoriasRepo.findById(id);
        if(categoria.isPresent())
            System.out.println(categoria.get());
        else
            System.out.println("Categoria no encontrada");
    }
    public void modificar(int id){
        var categoria =  categoriasRepo.findById(id);
        if(categoria.isPresent()){
            var catTmp = categoria.get();
            catTmp.setNombre("Ing. de Sofware");
            catTmp.setDescripcion("Desarrollo de Sistemas");
            categoriasRepo.save(catTmp);
        }else
            System.out.println("No existe categoria");
    }
    private void eliminar(int id){
        categoriasRepo.deleteById(id);
    }
    private void conteo(){
        System.out.println("Total categorias: " + categoriasRepo.count());
    }
    private void eliminarTodos(){
        categoriasRepo.deleteAll();
    }
    private void findAllById(){
        List<Integer> ids = new LinkedList<>();
        ids.addAll (List.of(1,4,10));

        var  categorias = categoriasRepo.findAllById(ids);
        categorias.forEach(System.out::println);
    }
//seccion 8 video 18
}
