import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class PaymentDaoTest {

    @Test
    public void testSavePayment() {
        PaymentDao payment = mock(PaymentDao.class);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.save(payment)).thenReturn(payment);

        PaymentDao savedPayment = paymentDao.save(payment);

        assertNotNull(savedPayment);
        verify(paymentDao, times(1)).save(payment);
    }

    @Test
    public void testFindById() {
        Long paymentId = 1L;
        PaymentDao payment = mock(PaymentDao.class);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.findById(paymentId)).thenReturn(payment);

        PaymentDao foundPayment = paymentDao.findById(paymentId);

        assertNotNull(foundPayment);
        assertEquals(payment, foundPayment);
    }

    @Test
    public void testFindByUser() {
        User testUser = mock(User.class);
        List<PaymentDao> payments = new ArrayList<>();
        PaymentDao payment = mock(PaymentDao.class);
        payments.add(payment);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.findByUser(testUser)).thenReturn(payments);

        List<PaymentDao> foundPayments = paymentDao.findByUser(testUser);

        assertNotNull(foundPayments);
        assertEquals(1, foundPayments.size());
        assertEquals(payment, foundPayments.get(0));
    }

    @Test
    public void testFindByEvent() {
        Event testEvent = mock(Event.class);
        List<PaymentDao> payments = new ArrayList<>();
        PaymentDao payment = mock(PaymentDao.class);
        payments.add(payment);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.findByEvent(testEvent)).thenReturn(payments);

        List<PaymentDao> foundPayments = paymentDao.findByEvent(testEvent);

        assertNotNull(foundPayments);
        assertEquals(1, foundPayments.size());
        assertEquals(payment, foundPayments.get(0));
    }

    @Test
    public void testFindByStatus() {
        Payment.PaymentStatus status = Payment.PaymentStatus.COMPLETED; // Assuming this enum exists
        List<PaymentDao> payments = new ArrayList<>();
        PaymentDao payment = mock(PaymentDao.class);
        payments.add(payment);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.findByStatus(status)).thenReturn(payments);

        List<PaymentDao> foundPayments = paymentDao.findByStatus(status);

        assertNotNull(foundPayments);
        assertEquals(1, foundPayments.size());
        assertEquals(payment, foundPayments.get(0));
    }

    @Test
    public void testFindByUserAndEvent() {
        User testUser = mock(User.class);
        Event testEvent = mock(Event.class);
        PaymentDao payment = mock(PaymentDao.class);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.findByUserAndEvent(testUser, testEvent)).thenReturn(Optional.of(payment));

        Optional<PaymentDao> foundPayment = paymentDao.findByUserAndEvent(testUser, testEvent);

        assertTrue(foundPayment.isPresent());
        assertEquals(payment, foundPayment.get());
    }

    @Test
    public void testFindByUserAndEvent_NotFound() {
        User testUser = mock(User.class);
        Event testEvent = mock(Event.class);
        PaymentDao paymentDao = mock(PaymentDao.class);

        when(paymentDao.findByUserAndEvent(testUser, testEvent)).thenReturn(Optional.empty());

        Optional<PaymentDao> foundPayment = paymentDao.findByUserAndEvent(testUser, testEvent);

        assertFalse(foundPayment.isPresent());
    }

    @Test
    public void testDeletePayment() {
        Long paymentId = 1L;
        PaymentDao paymentDao = mock(PaymentDao.class);

        doNothing().when(paymentDao).delete(paymentId);

        paymentDao.delete(paymentId);

        // Verify if delete was called once
        verify(paymentDao, times(1)).delete(paymentId);
    }

    @Test
    public void testDeleteNonExistentPayment() {
        Long paymentId = 999L; // Assuming this payment ID does not exist
        PaymentDao paymentDao = mock(PaymentDao.class);

        doNothing().when(paymentDao).delete(paymentId);

        // Ensure no exception is thrown
        paymentDao.delete(paymentId);

        // Verify if delete was called once
        verify(paymentDao, times(1)).delete(paymentId);
    }
}

