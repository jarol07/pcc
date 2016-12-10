package org.ulasalle.pcc.cliente;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tarea implements Serializable, Runnable
{

    private static final long serialVersionUID = -7019839295612785318L;

    private String proceso;
    private long horario;
    private String estado;
    private boolean cambio;

    public Tarea()
    {
    }

    public Tarea(String proceso, long horario)
    {
        this.proceso = proceso;
        this.horario = horario;
        this.estado = "programado";
        this.cambio = false;
    }

    public boolean esCambio()
    {
        return cambio;
    }

    public void setCambio(boolean cambio)
    {
        this.cambio = cambio;
    }

    public String getProceso()
    {
        return proceso;
    }

    public void setProceso(String proceso)
    {
        this.proceso = proceso;
    }

    public long getHorario()
    {
        return horario;
    }

    public void setHorario(long horario)
    {
        this.horario = horario;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
        this.cambio = true;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Tarea other = (Tarea) obj;
        if (this.horario != other.horario)
            return false;
        if (!Objects.equals(this.proceso, other.proceso))
            return false;
        return true;

    }

    @Override
    public void run()
    {

        String temp = "";
        switch (proceso)
        {
            case "Bloc de notas":
                temp = "gedit";
                break;
            case "Administrador de tareas":
                temp = "gnome-system-monitor";
                break;
            case "Calculadora":
                temp = "gnome-calculator";
                break;
            case "Panel de Control":
                temp = "gnome-control-center";
                break;
            case "Google Chrome":
                temp = "chromium";
                break;
            case "CMD":
                temp = "gnome-terminal";
                break;
            case "Explorador de Windows":
                temp = "nautilus";
                break;
        }

        ExecutorService ejecutor;
        ejecutor = Executors.newSingleThreadExecutor();
        String comando = temp;
        ejecutor.submit(() ->
        {
            while((new Date().getTime())<horario && this.estado.equals("programado"))
            {
                 try
                    {
                        this.estado = "programado";
                        Thread.sleep(1000);
                    } catch (InterruptedException exception)
                    {
                        exception.printStackTrace();
                    }
            }
            if(!this.estado.equals("detenido"))
            try
            {
                Runtime runtime = Runtime.getRuntime();
                Process process = runtime.exec(comando);
                this.estado = "en ejecucion";
                this.cambio = true;
                while (process != null && process.isAlive() && this.estado.equals("en ejecucion"))
                    try
                    {
                        this.estado = "en ejecucion";
                        Thread.sleep(1000);
                    } catch (InterruptedException exception)
                    {
                        exception.printStackTrace();
                    }
                if (this.estado.equals("detenido"))
                    process.destroy();
                else
                {
                    this.estado = "finalizado";
                    this.cambio = true;
                }
            } catch (IOException exception)
            {
                this.estado = "con error";
                this.cambio = true;
            }else
            {
                this.cambio = true;
            }

        });

    }

}
