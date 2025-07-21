package edu.leon;

import edu.leon.model.Categoria;
import edu.leon.model.Vacante;
import edu.leon.respositories.CategoriasRepository;
import edu.leon.respositories.VacantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private CategoriasRepository categoriasRepo;
    @Autowired
    private VacantesRepository vacantesRepo;

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
//        findAll();
//        existeId();
//        guardarTodas();
        //
//         buscarTodosJpa();
//        borrarTodoEnBloque();
//        buscarTodosOrdenados();
//        buscarTodosPaginacion();
        //buscarTodosPaginacionOrdenados();

//        buscarVacantes();
        guardarVacante();
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
    private void findAll(){
        categoriasRepo.findAll().forEach(System.out::println);
    }
    private  void existeId(){
        var existe = categoriasRepo.existsById(100);
        System.out.println(existe);
    }
    private void guardarTodas(){
        List<Categoria> categorias = new LinkedList<>();
        categorias.add(new Categoria("Desarrollo","Desarrollo de aplicaciones"));
        categorias.add(new Categoria("Finanzas","Finanzas y contabilidad"));
        categorias.add(new Categoria("Programador","Trabajos realacionados a desarrollo de aplicaciones"));
        categoriasRepo.saveAll(categorias);
    }
    //inicio de JpaRepository
    private void buscarTodosJpa(){
        //el metodo ya no regresa Iterable...
        //regresa List...
        List<Categoria> categorias = categoriasRepo.findAll();
        categorias.forEach(System.out::println);
    }
    private void borrarTodoEnBloque(){
        categoriasRepo.deleteAllInBatch();
    }
    private void buscarTodosOrdenados(){
        List<Categoria> categorias = categoriasRepo.findAll(Sort.by("nombre").descending());
        categorias.forEach(System.out::println);
    }
    private void buscarTodosPaginacion(){
        var pageCat = categoriasRepo.findAll(PageRequest.of(0,5));
        System.out.println("Total registros: " + pageCat.getTotalElements() + "");
        System.out.println("Total paginas: " + pageCat.getTotalPages() + "");
        pageCat.forEach(System.out::println);
    }
    public void buscarTodosPaginacionOrdenados(){
        var pageCat = categoriasRepo.findAll(PageRequest.of(0,5, Sort.by("nombre").descending()));
        pageCat.forEach(System.out::println);
//        System.out.println("Total registros: " + pageCat.getTotalElements() + "");
    }
    private void buscarVacantes(){
        var vacantes = vacantesRepo.findAll();
        vacantes.forEach(v->System.out.println(v.getId()+" "+v.getNombre() +"-" + v.getCategoria().getNombre()));
    }
    private void guardarVacante() {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de Sistemas");
        vacante.setDescripcion("Desarrollador de aplicaciones web");
        vacante.setFecha(java.time.LocalDate.now());
        vacante.setSalario(15000.0);
        vacante.setEstatus("Aprobada");
        vacante.setDestacado(0);
        vacante.setImagen("empresa1.png");
        vacante.setDetalles("<h1>Desarrollo de Sistemas</h1> <br/> <p>Desarrollador de aplicaciones web</p>");
        //5:06
        Categoria categoria = new Categoria();
        categoria.setId(14);
        vacante.setCategoria(categoria);

        vacantesRepo.save(vacante);

    }
//seccion 10 video 4
}
