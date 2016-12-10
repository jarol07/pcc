package org.ulasalle.pcc.servidor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.ulasalle.pcc.cliente.Tarea;

public class Interfaz extends javax.swing.JFrame
{

    private Servidor servidor;
    private ExecutorService ejecutor;
    private DefaultTableModel tableModel;
    private String columnas[];
    private SimpleDateFormat format;

    public Interfaz()
    {
        initComponents();

        this.procesos.setListData(llenarProcesos());
        this.servidor = new Servidor();
        this.tableModel = (DefaultTableModel) this.clientes.getModel();
        correrAutoRecarga();

        LocalDateTime localDateTime = LocalDateTime.now();
        anio.setText(Integer.toString(localDateTime.getYear()));
        mes.setText(Integer.toString(localDateTime.getMonthValue()));
        dia.setText(Integer.toString(localDateTime.getDayOfMonth()));
        hora.setText(Integer.toString(localDateTime.getHour()));
        minuto.setText(Integer.toString(localDateTime.getMinute()));
        segundo.setText(Integer.toString(localDateTime.getSecond()));
        columnas = new String[]
        {
            "ip", "coneccion", "proceso", "horario", "estado"
        };
        format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss ");
    }

    private String[] llenarProcesos()
    {
        String[] procesos = new String[]
        {
            "Bloc de notas",
            "Administrador de tareas",
            "Microsoft Word",
            "Microsoft Power Point",
            "Panel de Control",
            "Google Chrome",
            "CMD",
            "Paint",
            "Explorador de Windows"
        };
        return procesos;
    }

    private String getEstadoCliente(Cliente cliente)
    {
        return (cliente == null ? "no conectado" : cliente.estaConectado() ? "conectado" : "desconectado");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientes = new javax.swing.JTable();
        programar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        procesos = new javax.swing.JList<>();
        detener = new javax.swing.JButton();
        dia = new javax.swing.JTextField();
        mes = new javax.swing.JTextField();
        anio = new javax.swing.JTextField();
        hora = new javax.swing.JTextField();
        minuto = new javax.swing.JTextField();
        segundo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(clientes);

        programar.setText("Programar");
        programar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                programarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(procesos);

        detener.setText("Detener");
        detener.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                detenerActionPerformed(evt);
            }
        });

        dia.setText("DD");

        mes.setText("MM");

        anio.setText("YYYY");

        hora.setText("HH");

        minuto.setText("MM");
        minuto.setToolTipText("");

        segundo.setText("SS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(programar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dia, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mes, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anio, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minuto, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(segundo, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dia)
                            .addComponent(mes)
                            .addComponent(anio)
                            .addComponent(hora)
                            .addComponent(minuto)
                            .addComponent(segundo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(programar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        anio.getAccessibleContext().setAccessibleName("");
        hora.getAccessibleContext().setAccessibleName("");
        minuto.getAccessibleContext().setAccessibleName("");
        segundo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_programarActionPerformed
    {//GEN-HEADEREND:event_programarActionPerformed
        if (!this.ejecutor.isTerminated())
        {
            int indiceClientes = this.clientes.getSelectedRow();

            if (indiceClientes > -1 && !this.procesos.isSelectionEmpty())
            {
                Cliente cliente = this.servidor.getCliente((String) this.clientes.getValueAt(this.clientes.getSelectedRow(), 0));
                if (cliente != null && cliente.estaConectado())
                    cliente.enviar(
                            new Tarea(
                                    this.procesos.getSelectedValue(),
                                    LocalDateTime.of(
                                            Integer.parseInt(anio.getText()),
                                            Integer.parseInt(mes.getText()),
                                            Integer.parseInt(dia.getText()),
                                            Integer.parseInt(hora.getText()),
                                            Integer.parseInt(minuto.getText()),
                                            Integer.parseInt(segundo.getText())
                                    ).atZone(
                                            ZoneId.systemDefault()
                                    ).toInstant()
                                            .toEpochMilli()
                            )
                    );
            }
        }
    }//GEN-LAST:event_programarActionPerformed

    private void detenerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_detenerActionPerformed
    {//GEN-HEADEREND:event_detenerActionPerformed
        if (!this.ejecutor.isTerminated())
        {
            int indiceClientes = this.clientes.getSelectedRow();

            if (indiceClientes > -1 && !this.procesos.isSelectionEmpty())
            {
                Cliente cliente = this.servidor.getCliente((String) this.clientes.getValueAt(this.clientes.getSelectedRow(), 0));
                if (cliente != null && cliente.estaConectado())
                {
                    Tarea[] tareas = cliente.getTareas();
                    for (Tarea tarea : tareas)
                        try
                        {
                            if (tarea.getProceso().equals(this.clientes.getValueAt(this.clientes.getSelectedRow(), 2)) 
                                    && tarea.getHorario() == format.parse((String)this.clientes.getValueAt(this.clientes.getSelectedRow(), 3)).getTime() 
                                    && tarea.getEstado().equals(this.clientes.getValueAt(this.clientes.getSelectedRow(), 4))
                                    && !tarea.getEstado().equals("finalizado"))
                            {
                                tarea.setEstado("detenido");
                                cliente.enviar(tarea);
                            }
                        }catch (ParseException exception)
                        {
                            exception.printStackTrace();
                        }
                }
            }
        }
    }//GEN-LAST:event_detenerActionPerformed

    /*
this.ejecutor.shutdown();
        if (this.ejecutor.isTerminated())
            this.servidor.apagar();
     */
    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception)
        {
            exception.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Interfaz().setVisible(true);
            }
        });

    }

    public void configurarModelo(String columnas[], Object[][] datos)
    {
        for (int i = 0; i < tableModel.getRowCount(); i++)
            tableModel.removeRow(i);

        tableModel.setDataVector(datos, columnas);
        tableModel.fireTableStructureChanged();
        tableModel.fireTableDataChanged();
    }

    public void llenarModelo()
    {
        Map<String, Cliente> c;
        c = servidor.getClientes();

        int cantidad = 0;
        int resto=0;
        for (Map.Entry<String, Cliente> cliente : c.entrySet()){
            if (cliente.getValue() != null && cliente.getValue().estaConectado() && cliente.getValue().getTareas() != null)
                cantidad += cliente.getValue().getTareas().length;
            if(cliente.getValue() != null && (cliente.getValue().estaConectado() && cliente.getValue().getTareas()!=null))
                resto++;
        }
        
        Object[][] datos;
        datos = new Object[c.size() + (cantidad > 0 ? cantidad - resto : cantidad)][columnas.length];
        int indice = 0;

        for (Map.Entry<String, Cliente> cliente : c.entrySet())
            if (cliente.getValue() != null && cliente.getValue().estaConectado() && cliente.getValue().getTareas() != null)
                for (Tarea tarea : cliente.getValue().getTareas())
                {
                    datos[indice][0] = cliente.getKey();
                    datos[indice][1] = getEstadoCliente(cliente.getValue());
                    datos[indice][2] = tarea.getProceso();
                    datos[indice][3] = format.format(new Date(tarea.getHorario()));
                    datos[indice][4] = tarea.getEstado();
                    indice++;
                }
            else
            {
                datos[indice][0] = cliente.getKey();
                datos[indice][1] = getEstadoCliente(cliente.getValue());
                datos[indice][2] = "Ninguno";
                datos[indice][3] = "Ninguno";
                datos[indice][4] = "Ninguno";
                indice++;
            }

        configurarModelo(columnas, datos);
    }

    public Object[] getSeleccion()
    {
        Object[] fila = null;
        int indiceFila = clientes.getSelectedRow();
        if (indiceFila != -1)
        {
            fila = new Object[columnas.length];
            for (int i = 0; i < columnas.length; i++)
                fila[i] = clientes.getValueAt(indiceFila, i);
        }
        return fila;
    }

    public void seleccionarFila(Object[] fila)
    {
        if (fila != null)
        {
            int validos = 0;
            for (int indiceFila = 0; indiceFila < clientes.getRowCount(); indiceFila++)
                for (int indiceColumna = 0; indiceColumna < columnas.length-1; indiceColumna++)
                    if (clientes.getModel().getValueAt(indiceFila, indiceColumna).equals(fila[indiceColumna]))
                    {
                        if (++validos == columnas.length-1)
                        {
                            validos = indiceFila;
                            indiceFila = clientes.getRowCount();
                            indiceColumna = columnas.length;
                        }
                    } else
                        validos = 0;
            if(validos<clientes.getRowCount())
                clientes.setRowSelectionInterval(validos, validos);
        }
    }

    public void correrAutoRecarga()
    {

        this.ejecutor = Executors.newFixedThreadPool(2);
        this.ejecutor.submit(this.servidor);

        this.ejecutor.submit(() ->
        {
            while (true)
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Object[] fila = getSeleccion();
                        llenarModelo();
                        seleccionarFila(fila);
                    }
                });

                Thread.sleep(2500);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anio;
    private javax.swing.JTable clientes;
    private javax.swing.JButton detener;
    private javax.swing.JTextField dia;
    private javax.swing.JTextField hora;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mes;
    private javax.swing.JTextField minuto;
    private javax.swing.JList<String> procesos;
    private javax.swing.JButton programar;
    private javax.swing.JTextField segundo;
    // End of variables declaration//GEN-END:variables
}
