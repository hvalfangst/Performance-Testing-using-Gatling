package configuration

import (
	"encoding/json"
	"os"
)

type Configuration struct {
	Db Db `json:"db"`
}

type Db struct {
	DataSourceName string `json:"data_source_name"`
	MaxIdleConns   int    `json:"max_idle_conns"`
	MaxOpenConns   int    `json:"max_open_conns"`
}

func Get() (interface{}, error) {

	file, err := os.Open("src/configuration.json")
	if err != nil {
		return nil, err
	}

	defer func(file *os.File) {
		err := file.Close()
		if err != nil {

		}
	}(file)

	var config Configuration
	decoder := json.NewDecoder(file)
	err = decoder.Decode(&config)
	if err != nil {
		return nil, err
	}

	return config.Db, nil
}
