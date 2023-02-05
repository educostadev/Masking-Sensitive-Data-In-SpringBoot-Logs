package dev.educosta.masking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CustomerMapperTest {

    static final CustomerRequest CUSTOMER_REQUEST = new CustomerRequest("Ayrton Senna", "982.640.120-00", 34, "05423-040", "Dr Fernandes Coelho Street", "São Paulo", 85);
    static final CustomerDomain CUSTOMER_DOMAIN = new CustomerDomain(UUID.randomUUID(), "Rubens Barrichello", "870.562.320-00", 50, new CustomerDomain.Address("04795-100", "Av. das Nações Unidas", "São Paulo", 18801));
    static final CustomerEntity CUSTOMER_ENTITY = new CustomerEntity(UUID.randomUUID().toString(), "Nelson Piquet", "133.221.860-16", 70, "97123-000", "Copacabana Avenue", "Rio de Janeiro", 1000);

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void shouldConvertCustomerRequestToCustomerDomain() {
        var result = customerMapper.toDomain(CUSTOMER_REQUEST);
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isEqualTo(CUSTOMER_REQUEST.getName());
        assertThat(result.getDocumentNumber()).isEqualTo(CUSTOMER_REQUEST.getDocumentNumber());
        assertThat(result.getAge()).isEqualTo(CUSTOMER_REQUEST.getAge());
        assertThat(result.getAddress()).isNotNull();
        assertThat(result.getAddress().getZipCode()).isEqualTo(CUSTOMER_REQUEST.getZipCode());
        assertThat(result.getAddress().getStreet()).isEqualTo(CUSTOMER_REQUEST.getStreet());
        assertThat(result.getAddress().getCity()).isEqualTo(CUSTOMER_REQUEST.getCity());
        assertThat(result.getAddress().getNumber()).isEqualTo(CUSTOMER_REQUEST.getNumber());
    }

    @Test
    void shouldConvertCustomerDomainToCustomerEntity() {
        var result = customerMapper.toEntity(CUSTOMER_DOMAIN);
        assertThat(result.getId()).isEqualTo(CUSTOMER_DOMAIN.getId().toString());
        assertThat(result.getName()).isEqualTo(CUSTOMER_DOMAIN.getName());
        assertThat(result.getDocumentNumber()).isEqualTo(CUSTOMER_DOMAIN.getDocumentNumber());
        assertThat(result.getAge()).isEqualTo(CUSTOMER_DOMAIN.getAge());
        assertThat(result.getZipCode()).isEqualTo(CUSTOMER_DOMAIN.getAddress().getZipCode());
        assertThat(result.getStreet()).isEqualTo(CUSTOMER_DOMAIN.getAddress().getStreet());
        assertThat(result.getCity()).isEqualTo(CUSTOMER_DOMAIN.getAddress().getCity());
        assertThat(result.getNumber()).isEqualTo(CUSTOMER_DOMAIN.getAddress().getNumber());
    }

    @Test
    void shouldConvertCustomerEntityToCustomerDomain() {
        var result = customerMapper.toDomain(CUSTOMER_ENTITY);
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isEqualTo(CUSTOMER_ENTITY.getName());
        assertThat(result.getDocumentNumber()).isEqualTo(CUSTOMER_ENTITY.getDocumentNumber());
        assertThat(result.getAge()).isEqualTo(CUSTOMER_ENTITY.getAge());
        assertThat(result.getAddress()).isNotNull();
        assertThat(result.getAddress().getZipCode()).isEqualTo(CUSTOMER_ENTITY.getZipCode());
        assertThat(result.getAddress().getStreet()).isEqualTo(CUSTOMER_ENTITY.getStreet());
        assertThat(result.getAddress().getCity()).isEqualTo(CUSTOMER_ENTITY.getCity());
        assertThat(result.getAddress().getNumber()).isEqualTo(CUSTOMER_ENTITY.getNumber());
    }

}
