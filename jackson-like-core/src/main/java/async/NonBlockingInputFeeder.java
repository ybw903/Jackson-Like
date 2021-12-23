package async;

/**
 * non-blocking {@link com.fasterxml.jackson.core.JsonParser}에서 사용하는 인터페이스
 * 구문 분석할 입력을 제공하는 구현.
 * 피더는 구문 분석할 콘텐츠를 공급하는 엔터티에서 사용합니다. 어떤 주어진 지점에서
 * 콘텐츠의 한 청크만 처리할 수 있으므로 호출자는 다음을 처리해야 합니다.
 * 기존 콘텐츠가 구문 분석된 경우에만 더 많은 콘텐츠를 제공합니다(이는
 * 파서의 <code>nextToken</code>이 호출될 때). 일단 응용 프로그램을 사용하여
 * non-blocking 파서는 호출해야 하는 피드에 더 이상 데이터가 없습니다.
 * {@link #endOfInput}은 구문 분석할 논리적 입력(스트림)의 끝을 나타냅니다.
 *
 * @2.9부터
 */
public interface NonBlockingInputFeeder {

    /**
     * 더 많은 데이터를 공급해도 괜찮은지 확인하기 위해 호출된 메서드: 파서는 true를 반환합니다.
     * 구문 분석할 콘텐츠가 더 이상 없는 경우(더 공급해도 되는 경우) 그렇지 않으면 거짓
     * (아직 데이터가 공급되어서는 안 됨).
     *
     * @return {@code True} 더 많은 입력이 필요하고 공급될 수 있는 경우; {@code false} 경우
     * 디코딩할 입력이 아직 있습니다.
     **/
    public boolean needMoreInput();

    /**
     * 구문 분석할 데이터의 마지막 청크가 제공된 후 호출되어야 하는 메소드
     * (하위 클래스의 {@code feedInput} 포함); 상관없이 호출할 수 있습니다.
     * {@link #needMoreInput}
     * 반환합니다. 이 메서드를 호출한 후에는 더 이상 데이터를 공급할 수 없습니다. 그리고 파서는 가정한다
     * 더 이상 데이터를 사용할 수 없습니다.
     */
    public void endOfInput();
}
