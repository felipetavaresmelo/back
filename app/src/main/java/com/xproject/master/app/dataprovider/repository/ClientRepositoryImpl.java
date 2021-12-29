package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.domain.dataprovider.ClientDataProvider;
import com.xproject.master.domain.entity.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class ClientRepositoryImpl implements ClientDataProvider {

    List<Client> clientList;

    @Inject
    public ClientRepositoryImpl() {
        this.clientList = new ArrayList<>();
        this.clientList.add(Client.builder().clientId("1").name("Nome do cliente 1").build());
        this.clientList.add(Client.builder().clientId("2").name("Nome do cliente 2").build());
        this.clientList.add(Client.builder().clientId("3").name("Nome do cliente 3").build());

    }

    /**
     * Incluir um novo cliente.
     *
     * @param client
     * @return boolean
     */
    @Override
    public Boolean postClient(Client client) {
        return clientList.add(client);
    }

    /**
     * Consultar os dados do cliente pelo id.
     *
     * @param id do cliente
     * @return Objeto Client
     */
    @Override
    public Client getClientById(String id) {
        return clientList.stream()
                .filter(client -> client.getClientId().equals(id)).findFirst()
                .orElse(new Client());
    }

    /**
     * Alterar todos os dados cliente.
     *
     * @param client
     */
    @Override
    public void putClient(Client client) {
        clientList = clientList.stream()
                .map(c -> c.isEqual(client) ? client : c).collect(Collectors.toList());
    }

    /**
     * Alterar apenas alguns dados do cliente.
     *
     * @param client
     */
    @Override
    public void patchClient(Client client) {

    }

    /**
     * Remover um cliente.
     *
     * @param client
     * @return Boolean
     */
    @Override
    public Boolean deleteClient(Client client) {
        return null;
    }
}
