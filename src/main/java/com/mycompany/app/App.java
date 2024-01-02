package com.mycompany.app;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;
import com.google.common.primitives.Bytes;

import java.util.*;
import java.math.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(hash("abc"));
    }

    public static BigInteger hash(String input) {
        byte[] bytes = Hashing.murmur3_128().hashString(input, StandardCharsets.UTF_8).asBytes();
        List<Byte> want = Bytes.asList(Arrays.copyOfRange(bytes, 0, 8));
        Collections.reverse(want);
        byte[] wantBytes = Bytes.toArray(want);
        return new BigInteger(1, wantBytes);
    }
}
