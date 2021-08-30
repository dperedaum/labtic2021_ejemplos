package um.edu.uy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.edu.uy.business.entities.Client;
import um.edu.uy.business.exceptions.ClientAlreadyExists;
import um.edu.uy.business.exceptions.InvalidClientInformation;
import um.edu.uy.persistence.ClientRepository;

@Service
public class ClientMgr {

    @Autowired
    private ClientRepository clientRepository;

    public void addClient(long document, String name, String address)
            throws InvalidClientInformation, ClientAlreadyExists {

        if (name == null || "".equals(name) || address == null || "".equals(address)) {

            throw new InvalidClientInformation("Alguno de los datos ingresados no es correcto");

        }

        // Verifico si el cliente no existe

        if (clientRepository.findOneByDocument(document) != null) {

            throw new ClientAlreadyExists();
        }

        Client oClient = new Client(document, name, address);

        clientRepository.save(oClient);

    }


}
