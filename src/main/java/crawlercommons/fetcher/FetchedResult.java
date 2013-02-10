/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package crawlercommons.fetcher;

import java.security.InvalidParameterException;

import org.apache.tika.metadata.Metadata;

public class FetchedResult {
    private final String _baseUrl;
    private final String _fetchedUrl;
    private final long _fetchTime;
    private final byte[] _content;
    private final String _contentType;
    private final int _responseRate;
    private final Metadata _headers;
    private final String _newBaseUrl;
    private final int _numRedirects;
    private final String _hostAddress;
    private final int _httpStatus;
    private final String _reasonPhrase;

    private Payload _payload;

    public FetchedResult(final String baseUrl, final String redirectedUrl, final long fetchTime, final Metadata headers, final byte[] content, final String contentType, final int responseRate,
                    final Payload payload, final String newBaseUrl, final int numRedirects, final String hostAddress, final int httpStatus, final String reasonPhrase) {
        _payload = payload;

        if (baseUrl == null)
            throw new InvalidParameterException("baseUrl cannot be null");

        if (redirectedUrl == null)
            throw new InvalidParameterException("redirectedUrl cannot be null");

        if (headers == null)
            throw new InvalidParameterException("headers cannot be null");

        if (content == null)
            throw new InvalidParameterException("content cannot be null");

        if (contentType == null)
            throw new InvalidParameterException("contentType cannot be null");

        if (hostAddress == null)
            throw new InvalidParameterException("hostAddress cannot be null");

        _baseUrl = baseUrl;
        _fetchedUrl = redirectedUrl;
        _fetchTime = fetchTime;
        _content = content;
        _contentType = contentType;
        _responseRate = responseRate;
        _headers = headers;
        _newBaseUrl = newBaseUrl;
        _numRedirects = numRedirects;
        _hostAddress = hostAddress;
        _httpStatus = httpStatus;
        _reasonPhrase = reasonPhrase;
    }

    public Payload getPayload() {
        return _payload;
    }

    public void setPayload(final Payload payload) {
        _payload = payload;
    }

    public String getBaseUrl() {
        return _baseUrl;
    }

    public String getFetchedUrl() {
        return _fetchedUrl;
    }

    public long getFetchTime() {
        return _fetchTime;
    }

    public byte[] getContent() {
        return _content;
    }

    public int getContentLength() {
        return _content.length;
    }

    public String getContentType() {
        return _contentType;
    }

    public int getResponseRate() {
        return _responseRate;
    }

    public Metadata getHeaders() {
        return _headers;
    }

    public String getNewBaseUrl() {
        return _newBaseUrl;
    }

    public int getNumRedirects() {
        return _numRedirects;
    }

    public String getHostAddress() {
        return _hostAddress;
    }

    public int getHttpStatus() {
        return _httpStatus;
    }

    public String getReasonPhrase() {
        return _reasonPhrase;
    }

    @Override
    public String toString() {
        return "FetchedResult [_baseUrl=" + _baseUrl + ", _fetchedUrl=" + _fetchedUrl + ", _fetchTime=" + _fetchTime + ", _content=\n" + new String(_content) + ", \n_contentType=" + _contentType
                        + ", _responseRate=" + _responseRate + ", _headers=" + _headers + ", _newBaseUrl=" + _newBaseUrl + ", _numRedirects=" + _numRedirects + ", _hostAddress=" + _hostAddress
                        + ", _httpStatus=" + _httpStatus + ", _reasonPhrase=" + _reasonPhrase + ", _payload=" + _payload + "]";
    }

}
