package net.socialhub.twitter.web.utility;

import java.util.Random;

/**
 * Class for User Agent.
 * https://github.com/zedeus/nitter/blob/master/src/agents.nim
 */
public final class Agent {
    private Agent() {
    }

    private static Random rand = new Random();

    /** Choice random one element from array */
    private static <T> T sample(T[] array) {
        return array[rand.nextInt(array.length)];
    }

    private static String rv() {
        final String[] rvs = {
                "11.0", "40.0", "42.0", "43.0", "47.0", "50.0", "52.0",
                "53.0", "54.0", "61.0", "66.0", "67.0", "69.0", "70.0"
        };
        return (Math.random() < 0.1) ?
                "" : "; rv:" + sample(rvs);
    }

    // ============================================================================ //
    // OS
    // ============================================================================ //

    private static final String[] enc = { "; U", "; N", "; I", "" };

    /** Linux */
    private static String linux() {
        final String[] arch = { "i686", "x86_64", "arm" };
        final String[] window = { "X11", "Wayland", "Unknown" };
        final String[] distro = { "", "; Ubuntu/14.10", "; Ubuntu/16.10", "; Ubuntu/19.10", "; Ubuntu", "; Fedora" };

        return sample(window) + sample(enc) + "; Linux " + sample(arch) + sample(distro);
    }

    /** Windows */
    private static String windows() {
        final String[] arch = { "; WOW64", "; Win64; x64", "; ARM", "" };
        final String[] nt = { "5.1", "5.2", "6.0", "6.1", "6.2", "6.3", "6.4", "9.0", "10.0" };
        final String[] trident = { "", "; Trident/5.0", "; Trident/6.0", "; Trident/7.0" };

        return "Windows " + sample(nt) + sample(enc) + sample(arch) + sample(trident);
    }

    /** Mac */
    private static String mac() {
        final String[] os = { "6", "7", "8", "9", "9_3", "10", "10_1", "11", "12", "13", "14", "14_4", "15" };

        return "Macintosh; Intel Mac OS X 10_" + sample(os) + sample(enc);
    }

    // ============================================================================ //
    // Browser
    // ============================================================================ //

    private static String presto() {
        final String[] p = { "2.12.388", "2.12.407", "22.9.168", "2.9.201", "2.8.131", "2.7.62", "2.6.30", "2.5.24" };
        final String[] v = { "10.0", "11.0", "11.1", "11.5", "11.6", "12.00", "12.14", "12.16" };

        return "Presto/" + sample(p) + "Version/" + sample(v);
    }

    // ============================================================================ //
    // Samples
    // ============================================================================ //

    private static String product() {
        final String[] opera = { "Opera/9.80", "Opera/12.0" };
        return (Math.random() < 0.05) ? "Mozilla/5.0" : sample(opera);
    }

    private static String os() {
        double r = Math.random();
        String os = (r < 0.6) ? windows() :
                ((r < 0.9) ? linux() : mac());

        return "(" + os + rv() + ")";
    }

    private static String browser(String prod) {
        return prod.contains("Opera")
                ? presto() : "like Gecko";
    }

    // ============================================================================ //
    // Agent
    // ============================================================================ //

    /**
     * Generate User Agent
     */
    public static String get() {
        String prod = product();

        return prod
                + " " + os()
                + " " + browser(prod);
    }
}
