package blog.cosmos.home.flickzilla.utils;

import java.util.List;

import blog.cosmos.home.flickzilla.network.movie.MovieBrief;

public class NestedRecViewModel {
    private List<MovieBrief> mMovies;
    private Integer mGenreId;

    public NestedRecViewModel(List<MovieBrief> mMovies, Integer mGenreId) {
        this.mMovies = mMovies;
        this.mGenreId = mGenreId;
    }

    public List<MovieBrief> getmMovies() {
        return mMovies;
    }

    public void setmMovies(List<MovieBrief> mMovies) {
        this.mMovies = mMovies;
    }

    public Integer getmGenreId() {
        return mGenreId;
    }

    public void setmGenreId(Integer mGenreId) {
        this.mGenreId = mGenreId;
    }
}
