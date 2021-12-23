package async;

import java.io.IOException;

public interface ByteArrayFeeder extends NonBlockingInputFeeder{
    public void feedInput(byte[] data, int offset, int end) throws IOException;
}
