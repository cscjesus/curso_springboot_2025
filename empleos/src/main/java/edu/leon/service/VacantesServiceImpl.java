package edu.leon.service;

import edu.leon.model.Vacante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServiceImpl implements IVacanteService {
    List<Vacante> lista;
    public VacantesServiceImpl(){
        lista = new LinkedList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var vacante1 = new Vacante(1,"Ingeniero Civil","Se solicita Ing. Civil para " +
                "disenar puente peatonal", LocalDate.parse("08-02-2019",df),8500.0,1,"empresa1.png","Creada",null,null);
        lista.add(vacante1);

        vacante1 = new Vacante(2,"Contador Publico","Empresa importante solicita contandor con 5 anios de experiencia titulado",LocalDate.parse("09-02-2019",df),12000.0,0,"empresa2.png","Aprobada",null,null);
        lista.add(vacante1);

        vacante1 = new Vacante(3,"Ingeniero Electrico","Empresa internacional solicita Ingeniero Electrico para mantenimiento de instalacion electrica",LocalDate.parse("10-02-2019",df),10500.0,0,"no-image.png","Eliminada",null,null);
        lista.add(vacante1);

        vacante1 = new Vacante(4,"Disenador Grafico","Solicitamos Disenador Grafico titulado para disenar publicidad de la empresa",LocalDate.parse("01-02-2019",df),7500.0,1,"empresa3.png","Creada",null,null);

        lista.add(vacante1);

    }
    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer id) {
        return lista.stream()
                .filter(v ->v.getId()==id)
                .findFirst().orElse(null);
    }

    @Override
    public void guardar(Vacante vacante) {
        lista.add(vacante);
    }

    @Override
    public List<Vacante> buscarDestacadas() {
        return List.of();
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Vacante> buscarByExample(Example<Vacante> example) {
        return List.of();
    }

    @Override
    public Page<Vacante> buscarTodas(Pageable pageable) {
        return null;
    }
}
